package main;

import convertor.OrderConvertor;
import convertor.ReturnConvertor;
import convertor.SalesConvertor;
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

        String[] orderStrings = FileService.readLines("Documents\\order.txt");
        Order[] orders = OrderConvertor.makeStringsToOrderDocument(orderStrings);
        String[] returnStrings = FileService.readLines("Documents\\return.txt");
        Return[] returns = ReturnConvertor.makeStringsToReturnDocument(returnStrings);
        String[] salesStrings = FileService.readLines("Documents\\sales.txt");
        Sales[] sales1 = SalesConvertor.makeStringsToSalesDocument(salesStrings);


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
                        System.out.println("4.Read order document with line");
                        System.out.println("5.Print order document whose customer name starts with the letter A");
                        System.out.println("6.Back to general menu");
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
                                String[] strings = FileService.readLines("Documents\\order.txt");
                                for (String string : strings) {
                                    System.out.println(string);
                                }
                                break;
                            case 5:
                                orderService.printOrderDocumentByCustomerName(orders);
                                break;
                            case 6:
                                active = false;
                                break;
                            default:
                                System.out.println("Invalid command number");
                        }
                    }
                    break;
                case 2:
                    while (active) {
                        System.out.println("Enter command number");
                        System.out.println("1.Create document");
                        System.out.println("2.Check is document valid or not");
                        System.out.println("3.Save document in file");
                        System.out.println("4.Read return document with line");
                        System.out.println("5.Print return document which expired day count is more 6");
                        System.out.println("6.Back to general menu");
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
                                String[] strings = FileService.readLines("Documents\\return.txt");
                                for (String string : strings) {
                                    System.out.println(string);
                                }
                                break;
                            case 5:
                                returnService.printReturnDocumentByExpiredDay(returns);
                                break;
                            case 6:
                                active = false;
                                break;
                            default:
                                System.out.println("Invalid command number");
                        }
                    }
                    break;
                case 3:
                    while (active) {
                        System.out.println("Enter command number");
                        System.out.println("1.Create document");
                        System.out.println("2.Check is document valid or not");
                        System.out.println("3.Save document in file");
                        System.out.println("4.Read sales document with line");
                        System.out.println("5.Sort order document by price and print info");
                        System.out.println("6.Print sales  document which product price is less than 3");
                        System.out.println("7.Back to general menu");
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
                                String[] strings = FileService.readLines("Documents\\sales.txt");
                                for (String string : strings) {
                                    System.out.println(string);
                                }
                                break;
                            case 5:
                                salesService.sortOrderDocumentByPrice(sales1);
                                break;
                            case 6:
                                salesService.printSalesDocumentByProductPrice(sales1);
                                break;
                            case 7:
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
