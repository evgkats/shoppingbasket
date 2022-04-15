import React, {Component} from 'react';
import BuyButton from "./BuyButton";


class Product extends Component {

    render() {
        const { id, name, pricePerItem } = this.props.value;
        return (
            <tr>
                <th scope="row">{id}</th>
                <td>{name}</td>
                <td>{pricePerItem}</td>
                <td><BuyButton value={id} addProduct={ this.props.addProduct } /></td>
            </tr>
        );
    }
}

export default Product;
