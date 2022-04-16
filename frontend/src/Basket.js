import React, {Component} from 'react';
import BuyButton from "./BuyButton";


class Basket extends Component {

    render() {
        const {products, totalPrice, originalTotalPrice, totalShipping, total, discounted} = this.props.value;
        return (
            <table className="table">
                <thead>
                <tr>
                    {/*<td>Id </td>*/}
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
                        return <tr>
                            {/*<td>{product.id} </td>*/}
                            <td>{product.name}</td>
                            <td>{product.quantity}</td>
                            <td>{product.pricePerItem}</td>
                            <td>{product.shippingCostPerItem}</td>
                            <td class="text-end">{product.totalPrice}</td>
                            <td class="text-end">{product.totalShippingCost}</td>
                        </tr>
                    })
                }
                {!products.length && <td colSpan={6}>Add items to your basket!</td>}
                </tbody>
                { totalPrice && totalShipping &&
                    <tfoot>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td className={discounted ? "text-decoration-line-through text-end" : "text-end"}>{discounted ? originalTotalPrice : totalPrice}</td>
                        <td class="text-end">{totalShipping}</td>
                    </tr>
                    {discounted && <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>10% discount applied!</td>
                        <td class="text-end">{totalPrice}</td>
                        <td class="text-end">{totalShipping}</td>
                    </tr>
                    }
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td class="fw-bold text-end" colSpan={3}>Total Price + Shipping = {total}</td>
                    </tr>
                    </tfoot>
                }
            </table>
        );
    }
}

export default Basket;
