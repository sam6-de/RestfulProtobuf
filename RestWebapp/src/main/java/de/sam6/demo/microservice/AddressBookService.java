package de.sam6.demo.microservice;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Message;
import de.sam6.demo.protobuf.AddressBookProtos;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

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
