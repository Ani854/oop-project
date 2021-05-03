package main;

import model.Order;
import model.Return;
import model.Sales;
import service.FileService;
import service.OrderService;
import service.ReturnService;
import service.SalesService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        OrderService orderService = new OrderService();
        Order order = orderService.create();
        ReturnService returnService = new ReturnService();
        Return saleReturn = returnService.create();
        SalesService salesService = new SalesService();
        Sales sales = salesService.create();
        FileService.createFolder("Documents");
        FileService.createFile("Documents", "order.txt");
        FileService.createFile("Documents", "return.txt");
        FileService.createFile("Documents", "sales.txt");


        Scanner scanner = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("Which documents you want to use");
            System.out.println("1.Order document");
            System.out.println("2.Return document");
            System.out.println("3.Sales document");
            System.out.println("4.Finish sales Management");
            int c = scanner.nextInt();
            boolean active = true;
            switch (c) {
                case 1:
                    // boolean active2 = true;
                    while (active) {
                        System.out.println("Enter command number");
                        System.out.println("1.Create document");
                        System.out.println("2.Check is document valid or not");
                        System.out.println("3.Save document in file");
                        System.out.println("4.Back to general menu");
                        int a = scanner.nextInt();
                        switch (a) {
                            case 1:
                                order = orderService.create();
                                break;
                            case 2:
                                orderService.validate(order);
                                break;
                            case 3:
                                String doc = orderService.store(order);
                                FileService.write("Documents\\order.txt", doc + "\n");
                                break;
                            case 4:
                                active = false;
                                break;
                            default:
                                System.out.println("Invalid command number");
                        }
                    }
                    break;
                case 2:
                    //boolean active1 = true;
                    while (active) {
                        System.out.println("Enter command number");
                        System.out.println("1.Create document");
                        System.out.println("2.Check is document valid or not");
                        System.out.println("3.Save document in file");
                        System.out.println("4.Back to general menu");
                        int a = scanner.nextInt();
                        switch (a) {
                            case 1:
                                saleReturn = returnService.create();
                                break;
                            case 2:
                                returnService.validate(saleReturn);
                                break;
                            case 3:
                                String doc = returnService.store(saleReturn);
                                FileService.write("Documents\\return.txt", doc + "\n");
                                break;
                            case 4:
                                active = false;
                                break;
                            default:
                                System.out.println("Invalid command number");
                        }
                    }
                    break;
                case 3:
                    while (isActive) {
                        System.out.println("Enter command number");
                        System.out.println("1.Create document");
                        System.out.println("2.Check is document valid or not");
                        System.out.println("3.Save document in file");
                        System.out.println("4.Back to general menu");
                        int a = scanner.nextInt();
                        switch (a) {
                            case 1:
                                sales = salesService.create();
                            case 2:
                                salesService.validate(sales);
                                break;
                            case 3:
                                String doc = salesService.store(sales);
                                FileService.write("Documents\\sales.txt", doc + "\n");
                                break;
                            case 4:
                                active = false;
                                break;
                            default:
                                System.out.println("Invalid command number");
                        }
                    }
                    break;
                case 4:
                    isActive = false;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }
}
