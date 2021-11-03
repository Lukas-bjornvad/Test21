package integration.datalayer.booking;

import com.github.javafaker.Faker;
import datalayer.booking.BookingStorage;
import datalayer.booking.BookingStorageImpl;
import dto.BookingCreation;
import integration.ContainerizedDbIntegrationTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
class CreateBookingTest extends ContainerizedDbIntegrationTest {
    private BookingStorage bookingStorage;

    /* changed code */

    @BeforeAll
    public void Setup() throws SQLException {
        runMigration(2);

        bookingStorage = new BookingStorageImpl(getConnectionString(), "root", getDbPassword());

        var numBookings = bookingStorage.getBookings().size();
        if (numBookings < 100) {
            addFakeBookings(100 - numBookings);
        }
    }

    private void addFakeBookings(int numBookings) throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < numBookings; i++) {
            var time = new Time(12345678);
            var time2 = new Time(12345678);
            java.sql.Date sqlStartDate = new java.sql.Date(faker.date().birthday().getTime());
            BookingCreation c = new BookingCreation(faker.idNumber().hashCode(), faker.idNumber().hashCode(), sqlStartDate,time,time2);
            bookingStorage.createBooking(c);
        }

    }

    @Test
    public void mustSaveBookingInDatabaseWhenCallingCreateBooking() throws SQLException {
        // Arrange
        // Act
        int cosid = 123;
        int empid = 1234;
        bookingStorage.createBooking(new BookingCreation(cosid,empid, null, null,null));

        // Assert
        var Bookings = bookingStorage.getBookings();
        //assertTrue(2,2);
    }

    @Test
    public void mustReturnLatestId() throws SQLException {
        // Arrange
        // Act
        var id1 = bookingStorage.createBooking(new BookingCreation(1, 2, null, null,null));
        var id2 = bookingStorage.createBooking(new BookingCreation(3, 4 , null , null,null));

        // Assert
        assertEquals(1, id2 - id1);
    }
}
