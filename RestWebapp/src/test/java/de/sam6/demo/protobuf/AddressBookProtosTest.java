package de.sam6.demo.protobuf;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sascha
 * Date: 21.06.2015
 * Time: 13:44
 */
public class AddressBookProtosTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFullProto() throws Exception {
        AddressBookProtos.Person.newBuilder()
                .setId(1)
                .setName("Test User")
                .setEmail("test@abc.de")
                .addPhone(AddressBookProtos.Person.PhoneNumber.newBuilder()
                        .setNumber("+49 1234 9876543210")
                        .setType(AddressBookProtos.Person.PhoneType.HOME)
                        .build())
                .addPhone(AddressBookProtos.Person.PhoneNumber.newBuilder()
                        .setNumber("+49 170 9876543210")
                        .setType(AddressBookProtos.Person.PhoneType.MOBILE)
                        .build())
                .build();
    }
}