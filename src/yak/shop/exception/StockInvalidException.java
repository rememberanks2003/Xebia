package yak.shop.exception;

public class StockInvalidException extends Exception
{

    private static final long serialVersionUID = 1997753363232807009L;

		public StockInvalidException()
		{
		}

		public StockInvalidException(String message)
		{
			super(message);
		}

		public StockInvalidException(Throwable cause)
		{
			super(cause);
		}

		public StockInvalidException(String message, Throwable cause)
		{
			super(message, cause);
		}

		public StockInvalidException(String message, Throwable cause, 
                                           boolean enableSuppression, boolean writableStackTrace)
		{
			super(message, cause, enableSuppression, writableStackTrace);
		}

}