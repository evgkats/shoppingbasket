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
    }


    async addProduct(id) {
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
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(this.state.orderRequest)
        };
        await fetch('/orders', requestOptions)
            .then(response => response.json())
            .then(data => this.setState((state, props) => ({
                basket: data
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
                            <Basket value={ basket } />
                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default App;
