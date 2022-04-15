import React, {Component} from 'react';
import Product from "./Product";


class Products extends Component {

    render() {
        return (
            <table className="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Buy</th>
                </tr>
                </thead>
                <tbody>
                {this.props.value.map(p => <Product value={p} key={p.id} addProduct={this.props.addProduct}/>)}
                </tbody>
            </table>
        );
    }
}

export default Products;
