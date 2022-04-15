import React, {Component} from 'react';
import './App.css';
import Products from "./Products";
import {Container, Col, Row} from "reactstrap";


class App extends Component {
    constructor(props) {
        super(props)
        this.state = {
            products: []
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
        const { products } = this.state;
        return (
            <div className="App">
                <Container>
                    <Row>
                        <Col className="bg-light border">
                            <h2>Available Products</h2>
                            <Products value={products} addProduct={ this.addProduct} />
                        </Col>
                        <Col className="bg-light border">
                            <h2>Basket</h2>
                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default App;
