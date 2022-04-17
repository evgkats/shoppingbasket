import React, {Component} from 'react';
import './App.css';
import Products from "./Products";
import {Container, Col, Row} from "reactstrap";
import Basket from "./Basket";


class App extends Component {
    constructor(props) {
        super(props)
        this.state = {
            products: [],
            orderRequest: {
                customerId: "",
                products: []
            },
            basket: {
                products: [],
                discounted: false
            }
        }
        this.addProduct = this.addProduct.bind(this)
        this.updateProductQuantity = this.updateProductQuantity.bind(this)
    }

    async addProduct(id, quantity) {
        console.log("added: " + id);
        const newProducts = this.state.orderRequest.products.slice();
        let addedItem = newProducts.find(product => product.id === id);
        if (addedItem) {
            addedItem.quantity = addedItem.quantity + 1;
        } else {
            newProducts.push({ id: id, quantity: 1 })
        }
        this.setState((state, props) => ({
            orderRequest:{
                customerId: "",
                products: newProducts
            }
        }));
        await this.submitOrder();
    }

    async updateProductQuantity(id, quantity) {
        const newProducts = this.state.orderRequest.products.slice(0);
        newProducts.forEach(product => {
            if(product.id == id) {
                product.quantity = Number(quantity);
            }
        });
        this.setState((state, props) => ({
            orderRequest:{
                customerId: "",
                products: newProducts
            }
        }));
        await this.submitOrder();
    }

    async submitOrder() {
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(this.state.orderRequest)
        };
        await fetch('/orders', requestOptions)
            .then(response => response.json())
            .then(data => this.setState((state, props) => ({
                basket: {
                    products: Object.assign([], data.products),
                    discounted: data.discounted,
                    totalPrice: data.totalPrice,
                    originalTotalPrice: data.originalTotalPrice,
                    totalShipping: data.totalShipping,
                    total: data.total
                }
            })));
    }

    async componentDidMount() {
        const response = await fetch('/products');
        const body = await response.json();
        this.setState({products: body});
    }

    render() {
        const { products, basket } = this.state;
        return (
            <div className="App">
                <Container>
                    <Row>
                        <Col className="bg-light border" xs="5">
                            <h2>Available Products</h2>
                            <Products value={ products } addProduct={ this.addProduct } />
                        </Col>
                        <Col className="bg-light border">
                            <h2>Basket</h2>
                            <Basket value={ basket } updateProductQuantity={ this.updateProductQuantity }/>
                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default App;
