import lombok.RequiredArgsConstructor;
import java.time.temporal.ValueRange;

@RequiredArgsConstructor
public enum HttpCodes
{

    INFORMATIONAL(100, 199, (code) -> System.out.println("http code: " + code)),
    SUCCESS(200, 299, (code) -> System.out.println("http code: " + code)),
    REDIRECTION(300, 399, (code) -> System.out.println("http code: " + code)),
    CLIENT_ERROR(400, 499, (code) -> System.out.println("http code: " + code)),
    SERVER_ERROR(500, 599, (code) -> System.out.println("http code: " + code));

    final int minCode;
    final int maxCode;
    final Action action;

    public static void findValueByCode(int code)
    {
        for(HttpCodes v : HttpCodes.values())
        {
            if(ValueRange.of(v.minCode, v.maxCode).isValidValue(code))
                v.action(code);
        }
    }

    public void action(int code)
    {
        if(action != null)
            action.action(code);
    }

    @FunctionalInterface
    public interface Action
    {
        void action(int code);
    }
}
