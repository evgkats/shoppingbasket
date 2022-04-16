import React, {Component} from 'react';
import BuyButton from "./BuyButton";


class Basket extends Component {

    render() {
        const {products, totalPrice, originalTotalPrice, totalShipping, total, discounted} = this.props.value;
        return (
            <table className="table">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Item Price</th>
                    <th>Item Shipping</th>
                    <th>Total Price</th>
                    <th>Total Shipping</th>
                </tr>
                </thead>
                <tbody>
                {
                    products?.map(product => {
                        return <tr key={product.id}>
                            <td>{product.name}</td>
                            <td>{product.quantity}</td>
                            <td>{product.pricePerItem}</td>
                            <td>{product.shippingCostPerItem}</td>
                            <td className="text-end">{product.totalPrice}</td>
                            <td className="text-end">{product.totalShippingCost}</td>
                        </tr>
                    })
                }
                {!products.length && <tr><td colSpan={6}>Add items to your basket!</td></tr>}
                </tbody>
                { totalPrice && totalShipping &&
                    <tfoot>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td className={discounted ? "text-decoration-line-through text-end" : "text-end"}>{discounted ? originalTotalPrice : totalPrice}</td>
                        <td className="text-end">{totalShipping}</td>
                    </tr>
                    {discounted && <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>10% discount applied!</td>
                        <td className="text-end">{totalPrice}</td>
                        <td className="text-end">{totalShipping}</td>
                    </tr>
                    }
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td className="fw-bold text-end" colSpan={3}>Total Price + Shipping = {total}</td>
                    </tr>
                    </tfoot>
                }
            </table>
        );
    }
}

export default Basket;
