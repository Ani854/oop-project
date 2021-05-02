package main;

import model.Order;
import model.Return;
import model.Sales;
import service.FileService;
import service.OrderService;
import service.ReturnService;
import service.SolesService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        OrderService orderService = new OrderService();
        Order order = orderService.create();
        ReturnService returnService = new ReturnService();
        Return saleReturn = returnService.create();
        SolesService salesService = new SolesService();
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
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    while (isActive) {
                        System.out.println("Enter command number");
                        System.out.println("1.Check is document valid or not");
                        System.out.println("2.Create string of document and save in file");
                        int a = scanner.nextInt();
                        switch (a) {
                            case 1:
                                orderService.validate(order);
                                break;
                            case 2:
                                String doc = orderService.store(order);
                                FileService.write("Documents\\order.txt", doc);
                            default:
                                System.out.println("Invalid command number");
                        }
                    }
                    break;
                case 2:
                    while (isActive) {
                        System.out.println("Enter command number");
                        System.out.println("1.Check is document valid or not");
                        System.out.println("2.Create string of document and save in file");
                        int a = scanner.nextInt();
                        switch (a) {
                            case 1:
                                returnService.validate(saleReturn);
                                break;
                            case 2:
                                String doc = returnService.store(saleReturn);
                                FileService.write("Documents\\return.txt", doc);
                            default:
                                System.out.println("Invalid command number");
                        }
                    }
                    break;
                case 3:
                    while (isActive) {
                        System.out.println("Enter command number");
                        System.out.println("1.Check is document valid or not");
                        System.out.println("2.Create string of document and save in file");
                        int a = scanner.nextInt();
                        switch (a) {
                            case 1:
                                salesService.validate(sales);
                                break;
                            case 2:
                                String doc = salesService.store(sales);
                                FileService.write("Documents\\sales.txt", doc);
                            default:
                                System.out.println("Invalid command number");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }
}
