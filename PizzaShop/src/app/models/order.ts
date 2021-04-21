import { User } from "./User";
import {Items} from "./Items"
export class Order {

    constructor(user, shippingAddress, orderDate, isPending, products) {
        this.user = user;
        this.shippingAddress = shippingAddress;
        this.orderDate = orderDate;
        this.isPending = isPending;
        this.products = products;
    }
    orderNo: number;
    user: User;
    shippingAddress: string;
    orderDate: Date;
    isPending: boolean;
    products: Items[];
}
