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

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
class CreateBookingTest extends ContainerizedDbIntegrationTest {
    private BookingStorage bookingStorage;

    /* changed code */
/*
    @BeforeAll
    public void Setup() throws SQLException {
        runMigration(2);

        bookingStorage = new BookingStorageImpl(getConnectionString(), "root", getDbPassword());

        var numBookings = bookingStorage.getBookings().size();
        if (numBookings < 100) {
            addFakeBookings(100 - numBookings);
        }
    }

    /*private void addFakeBookings(int numBookings) throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < numBookings; i++) {
            BookingCreation c = new BookingCreation(faker.idNumber().hashCode(), faker.idNumber(), faker.date(), faker.);
            BookingStorage.createBooking(c);
        }

    }

    @Test
    public void mustSaveBookingInDatabaseWhenCallingCreateBooking() throws SQLException {
        // Arrange
        // Act
        BookingStorage.createBooking(new BookingCreation("John","Carlssonn", null, null));

        // Assert
        var Bookings = BookingStorage.getBookings();
        assertTrue(
                Bookings.stream().anyMatch(x ->
                        x.getFirstname().equals("John") &&
                        x.getLastname().equals("Carlssonn")));
    }

    @Test
    public void mustReturnLatestId() throws SQLException {
        // Arrange
        // Act
        var id1 = BookingStorage.createBooking(new BookingCreation("a", "b", null, null));
        var id2 = BookingStorage.createBooking(new BookingCreation("c", "d" , null , null));

        // Assert
        assertEquals(1, id2 - id1);
    }*/
}
