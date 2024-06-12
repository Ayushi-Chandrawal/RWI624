
import MODEL.*;
import SERVICE.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

    public class Main {
        private CustomerService customerService;
        private OrderService orderService;
        private OrderDetailService orderDetailService;
        private ProductService productService;
        private SupplierService supplierService;
        private Scanner scanner;

        public static void main(String[] args) {
//
            Main main = new Main();
            main.run();
        }

        public Main() {
            customerService = new CustomerService();
            orderService = new OrderService();
            orderDetailService = new OrderDetailService();
            productService = new ProductService();
            supplierService = new SupplierService();
            scanner = new Scanner(System.in);
        }

        public void run() {
            while (true) {
                showMenu();
                int choice = Integer.parseInt(scanner.nextLine());

                try {
                    switch (choice) {
                        case 1:
                            addSupplier();
                            break;
                        case 2:
                            addProduct();
                            break;
                        case 3:
                            addCustomer();
                            break;
                        case 4:
                            placeOrder();
                            break;
                        case 5:
                            viewAllCustomers();
                            break;
                        case 6:
                            viewAllProducts();
                            break;
                        case 7:
                            viewAllOrders();
                            break;
                        case 8:
                            viewAllOrderDetails();
                            break;
                        case 9:
                            viewAllSuppliers();
                            break;
                        case 10:
                            updateCustomer();
                            break;
                        case 11:
                            deleteCustomer();
                            break;
                        case 12:
                            viewCustomerById();
                            break;
                        case 13:
                            deleteProduct();
                            break;
                        case 14:
                            deleteOrder();
                            break;
                        case 15:
                            deleteSupplier();
                            break;
                        case 16:
                            System.out.println("Exiting...");
                            scanner.close();
                            return;
                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        private void showMenu() {
            System.out.println("\nClothing Management System");
            System.out.println("1. Add Supplier");
            System.out.println("2. Add Product");
            System.out.println("3. Add Customer");
            System.out.println("4. Place Order");
            System.out.println("5. View All Customers");
            System.out.println("6. View All Products");
            System.out.println("7. View All Orders");
            System.out.println("8. View All Order Details");
            System.out.println("9. View All Suppliers");
            System.out.println("10. Update Customer");
            System.out.println("11. Delete Customer");
            System.out.println("12. View Customer by ID");
            System.out.println("13. Delete Product");
            System.out.println("14. Delete Order");
            System.out.println("15. Delete Supplier");
            System.out.println("16. Exit");
            System.out.print("Enter your choice: ");
        }

        private void addSupplier() throws SQLException {
            System.out.print("Enter Supplier1 name: ");
            String supplierName = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter phone: ");
            String phone = scanner.nextLine();

            Supplier newSupplier = new Supplier(0, supplierName, email, phone);
            supplierService.addSupplier(newSupplier);
            System.out.println("Supplier added successfully!");
        }

        private void addProduct() throws SQLException {
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            System.out.print("Enter size: ");
            String size = scanner.nextLine();
            System.out.print("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter supplier ID: ");
            int supplierId = Integer.parseInt(scanner.nextLine());

            Product newProduct = new Product(0, productName, category, size, price, supplierId);
            productService.addProduct(newProduct);
            System.out.println("Product added successfully!");
        }

        private void addCustomer() throws SQLException {
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter phone: ");
            String phone = scanner.nextLine();

            Customer newCustomer = new Customer(0, firstName, lastName, email, phone);
            customerService.addCustomer(newCustomer);;
            System.out.println("Customer added successfully!");
        }

        private void placeOrder() throws SQLException {
//            System.out.print("Enter order ID: ");
//            int orderId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter customer ID: ");
            int customerId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter date (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();
            LocalDate orderDate = LocalDate.parse(dateInput);
            System.out.print("Enter total amount: ");
            double totalAmount = Double.parseDouble(scanner.nextLine());

            Order newOrder = new Order(0, customerId, new java.sql.Date(System.currentTimeMillis()), totalAmount);
            orderService.addOrder(newOrder);

            System.out.print("Enter number of products in the order: ");
            int numberOfProducts = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numberOfProducts; i++) {
                System.out.print("Enter product ID: ");
                int productId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter unit price: ");
                double unitPrice = Double.parseDouble(scanner.nextLine());

                OrderDetails orderDetail = new OrderDetails(0, newOrder.getOrderId(), productId, quantity, unitPrice);
                orderDetailService.addOrderDetails(orderDetail);
            }

            System.out.println("Order placed successfully!");
        }

        private void viewAllCustomers() throws SQLException {
            List<Customer> customers = customerService.getAllCustomer();
            System.out.println("\nCustomer List:");
            for (Customer customer : customers) {
                System.out.println("ID: " + customer.getId() + ", first Name: " + customer.getFirstName() +
                        ", last Name: " + customer.getLastName()+ ", Email: " + customer.getEmail() + ", Phone: " + customer.getPhone());
            }

        }


        private void viewAllProducts() throws SQLException {
            List<Product> products = productService.getAllProduct();
            System.out.println("\nProduct List:");
            for (Product product : products) {
                System.out.println("ID: " + product.getProductId() + ",  Product Name: " + product.getProductName() +
                        ", Category: " + product.getCategory() + ", Size: " + product.getSize() + ", Supplier Id " + product.getSupplierId());
            }

        }

        private void viewAllOrders() throws SQLException {
            List<Order> orders = orderService.getAllOrder();
            System.out.println("\nOrder List:");
            for (Order order : orders) {
                System.out.println(order);
            }
        }

        private void viewAllOrderDetails() throws SQLException {
            List<OrderDetails> orderDetails = orderDetailService.getAllOrderDetails();
            System.out.println("\nOrder Detail List:");
            for (OrderDetails orderDetail : orderDetails) {
                System.out.println(orderDetail);
            }
        }

        private void viewAllSuppliers() throws SQLException {
            List<Supplier> suppliers = supplierService.getAllSupplier();
            System.out.println("\nSupplier List:");
            for (Supplier supplier : suppliers) {
                System.out.println(supplier);
            }
        }

        private void updateCustomer() throws SQLException {
            System.out.print("Enter customer ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter new first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter new last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone: ");
            String phone = scanner.nextLine();

            Customer customer = new Customer();
            customer.setId(id);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setPhone(phone);

            customerService.updateCustomer(customer);
            System.out.println("Customer updated successfully!");
        }

        private void deleteCustomer() throws SQLException {
            System.out.print("Enter customer ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            customerService.deleteCustomer(id);
            System.out.println("Customer deleted successfully!");
        }

        private void deleteProduct() throws SQLException {
            System.out.print("Enter product ID to delete: ");
            int productId = Integer.parseInt(scanner.nextLine());

            productService.deleteProduct(productId);
            System.out.println("Product deleted successfully!");
        }

        private void deleteOrder() throws SQLException {
            System.out.print("Enter order ID to delete: ");
            int orderId = Integer.parseInt(scanner.nextLine());

            orderService.deleteOrder(orderId);
            System.out.println("Order deleted successfully!");
        }

        private void deleteSupplier() throws SQLException {
            System.out.print("Enter supplier ID to delete: ");
            int supplierId = Integer.parseInt(scanner.nextLine());

            supplierService.deleteSupplier(supplierId);
            System.out.println("Supplier deleted successfully!");
        }

        private void viewCustomerById() throws SQLException {
            System.out.print("Enter customer ID to view: ");
            int id = Integer.parseInt(scanner.nextLine());

            Customer customer = customerService.getCustomerById(id);
            if (customer != null) {
                System.out.println(customer);
            } else {
                System.out.println("Customer not found with ID: " + id);
            }
        }


       }