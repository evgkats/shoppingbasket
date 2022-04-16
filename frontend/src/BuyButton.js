import React, {Component} from 'react';
import {Button} from 'reactstrap';

class BuyButton extends Component {

    // async addProduct(id) {
    //     console.log("added: " + id)
    // }

    render() {
        return (
            <Button color="primary" onClick={() => this.props.addProduct(this.props.value)}>Add</Button>
        );
    }
}

export default BuyButton;
