package de.sam6.demo.microservice;

import de.sam6.demo.protobuf.AddressBookProtos;

import javax.ws.rs.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sascha
 * Date: 19.06.2015
 * Time: 21:08
 */
@Path("/person")
public class AddressBookService {
    @GET
    @Produces("application/x-protobuf")
    public AddressBookProtos.Person getPerson() {
        return AddressBookProtos.Person.newBuilder()
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

    @POST
    @Consumes("application/x-protobuf")
    @Produces("application/x-protobuf")
    public AddressBookProtos.Person reflect(AddressBookProtos.Person person) {
        return person;
    }

}
