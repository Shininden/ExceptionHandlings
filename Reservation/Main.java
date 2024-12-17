package ExceptionHandling.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try 
        {
            System.out.print("Room Number: ");
            int num = sc.nextInt();

            System.out.print("Check-in date (dd/MM/yyy): ");
            Date checkIn = sdf.parse(sc.next());

            System.out.print("Check-out date (dd/MM/yyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reserve reservation = new Reserve(num, checkIn, checkOut);
            System.out.println(reservation);


            System.out.println();


            System.out.println("Enter data to update the reservation");
            
            System.out.print("Check-in date (dd/MM/yyy): ");
            checkIn = sdf.parse(sc.next());
    
            System.out.print("Check-out date (dd/MM/yyy): ");
            checkOut = sdf.parse(sc.next());

    
            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        } 
        catch (CheckOutException e) {
            System.err.println("Error: " + e.getMessage());
        } 
        catch (ReservationException e) {
            System.err.println("Error: " + e.getMessage());
        } 
        catch (ParseException e){
            System.err.println("Error: Invalid date format");
        }
        catch(RuntimeException e){
            System.err.println("Unexpected error");
        }

        sc.close();
    }
}