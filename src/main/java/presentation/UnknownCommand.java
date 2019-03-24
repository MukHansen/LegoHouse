package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LegoHouseException;

/**
 The purpose of UnknownCommand is to...

 @author Mkhansen
 */
public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws logic.LegoHouseException {
        String msg = "Unknown command. Contact IT";
        throw new LegoHouseException( msg );
    }

}
