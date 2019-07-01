package validator;

import entity.Dot;
import exception.WrongParamsException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataConverterTest {

    @Test
    public void convertDot_validDot_true() throws WrongParamsException {
        //given
        DataConverter dataConverter = DataConverter.getInstance();
        String str = "3.0,0.0";
        Dot dot = new Dot(3, 0);
        //when
        Dot testDot = dataConverter.convertDot(str);
        //then
        Assert.assertEquals(dot, testDot);
    }

    @Test(expectedExceptions = WrongParamsException.class)
    public void convertDot_invalidDot_WrongParamsException() throws WrongParamsException {
        //given
        DataConverter dataConverter = DataConverter.getInstance();
        String str = "3,0,0.4";
        //when
        Dot testDot = dataConverter.convertDot(str);
        //then
        Assert.assertFalse(false);
    }


}
