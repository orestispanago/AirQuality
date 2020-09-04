import React, { useEffect, useState } from "react";
import { Link } from 'react-router-dom';
import AdminProducts from './admin-products';
import AdminOrders from './admin-orders';
import AdminPlans from './admin-plans';

function AdminPanel() {
    const [isFirstRender, setIsFirstRender] = useState(true);
    // const [totalPrice, setTotalPrice] = useState(0);

    // Will run once after component load
    // useEffect(() => {
    //     getCartData();
    // }, []);

    //Will run once after component load
    // useEffect(() => {
    //     if (isFirstRender) setIsFirstRender(false);
    //     if (!isFirstRender) {
    //         let sum = 0;
    //         cartItems.forEach(cartItem => {
    //             sum += cartItem.product.price * cartItem.quantity;
    //         })

    //         setTotalPrice(sum);
    //     }

    // }, [cartItems]);

    return (
        <div className="container pt-5 pb-5">

            {/* <p className="pt-5 text-left">
                <a className="btn btn-primary" data-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Orders</a>
                <button className="btn btn-primary" type="button" data-toggle="collapse" data-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2">Products</button>
                <button className="btn btn-primary" type="button" data-toggle="collapse" data-target="#multiCollapseExample3" aria-expanded="false" aria-controls="multiCollapseExample2">Plans</button>
            </p> */}
            <div className="row">
                <div className="col-12 pt-5">
                    <div >
                        <div className="card card-body">
                            <AdminProducts></AdminProducts>
                        </div>
                    </div>
                </div>
                <div className="col-12 pt-5">
                    <div >
                        <div className="card card-body">
                            <AdminOrders></AdminOrders>
                        </div>
                    </div>
                </div>
                <div className="col-12 pt-5">
                    <div >
                        <div className="card card-body">
                            <AdminPlans></AdminPlans>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )
}

export default AdminPanel;



