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
            basket: {
                // products: []
                "id": 1,
                "products": [
                    {
                        "id": 1,
                        "name": "Pasta",
                        "pricePerItem": "0.80",
                        "shippingCostPerItem": "2.00",
                        "totalPrice": "3.20",
                        "totalShippingCost": "8.00",
                        "quantity": 4
                    },
                    {
                        "id": 2,
                        "name": "Rice",
                        "pricePerItem": "1.50",
                        "shippingCostPerItem": "4.50",
                        "totalPrice": "3.00",
                        "totalShippingCost": "9.00",
                        "quantity": 2
                    },
                    {
                        "id": 3,
                        "name": "Flour",
                        "pricePerItem": "1.00",
                        "shippingCostPerItem": "5.00",
                        "totalPrice": "5.00",
                        "totalShippingCost": "25.00",
                        "quantity": 5
                    },
                    {
                        "id": 11,
                        "name": "Olive Oil",
                        "pricePerItem": "15.00",
                        "shippingCostPerItem": "75.00",
                        "totalPrice": "30.00",
                        "totalShippingCost": "150.00",
                        "quantity": 2
                    }
                ],
                "totalPrice": "41.20",
                "originalTotalPrice": null,
                "totalShipping": "192.00",
                "total": "233.20",
                "discounted": false
            }
        }
        this.addProduct = this.addProduct.bind(this)
    }


    async addProduct(id) {
        console.log("added: " + id)
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
