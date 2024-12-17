package ExceptionHandling.Reservation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class CheckOutException extends Exception
{
    public CheckOutException() {
        super("Error in reservation: The check-out date musn't be before the check-in date");
    }
}

class ReservationException extends Exception
{
    public ReservationException() {
        super("Error in reservation: The reservation dates for the update must be of future dates");
    }
}

public class Reserve 
{
    private Integer roomNumber;
    //so that a new SimpleDateFormat isn't instanciated for each Reserve object
    //        |
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date checkIn;
    private Date checkOut;


    public Reserve(Integer roomNumber, Date checkIn, Date checkOut) throws CheckOutException
    {
        validateCheckOut(checkIn, checkOut); //In the beginning cuz of sth called programação defensiva

        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long stayDuration()
    {
        long milli_SecondsDiff = this.checkOut.getTime() - this.checkIn.getTime();
        return TimeUnit.DAYS.convert(milli_SecondsDiff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) throws ReservationException, CheckOutException
    {
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        validateReservation();
    }

    public void validateCheckOut(Date checkIn, Date checkOut) throws CheckOutException
    {
        if(checkIn.after(checkOut)){
            throw new CheckOutException();
        }
    }
    public void validateReservation() throws ReservationException, CheckOutException
    {
        Date now = new Date();

        if(this.checkIn.before(now) || checkOut.before(now)){
            throw new ReservationException();
        }

        validateCheckOut(this.checkIn, this.checkOut);
    }

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation: ");
        sb.append("Room ");
        sb.append(getRoomNumber() + ", ");

        sb.append("check-in: ");
        sb.append(sdf.format(checkIn) + ", ");

        sb.append("check-out: ");
        sb.append(sdf.format(checkOut) + ", ");

        sb.append(stayDuration());
        sb.append(" nights");

        return sb.toString();
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }
    public Date getCheckOut() {
        return checkOut;
    }
}