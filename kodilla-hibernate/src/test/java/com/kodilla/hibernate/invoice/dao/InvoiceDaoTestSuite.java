package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("product1");
        Product product2 = new Product("product2");
        Product product3 = new Product("product3");

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        Invoice invoice1 = new Invoice("FV20180501");
        Invoice invoice2 = new Invoice("FV20180502");

        Item item1 = new Item(BigDecimal.valueOf(23.15), 1);
        Item item2 = new Item(BigDecimal.valueOf(21.99), 2);
        Item item3 = new Item(BigDecimal.valueOf(17.55), 3);
        Item item4 = new Item(BigDecimal.valueOf(21.99), 1);

        product1.getItems().add(item1);
        product2.getItems().add(item2);
        product3.getItems().add(item3);
        product2.getItems().add(item4);

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);
        item4.setProduct(product2);

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice2.getItems().add(item3);
        invoice2.getItems().add(item4);

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice2);
        item4.setInvoice(invoice2);

        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);

        //When
        int size1 = invoice1.getItems().size();
        int size2 = invoice2.getItems().size();

        //Then
        Assert.assertEquals(2, size1);
        Assert.assertEquals(2, size2);

        //CleanUp
        try {
            productDao.deleteById(product1.getId());
            productDao.deleteById(product2.getId());
            productDao.deleteById(product3.getId());
            invoiceDao.deleteById(invoice1.getId());
            invoiceDao.deleteById(invoice2.getId());

        } catch (Exception e) {
            //do nothing
        }
    }
}