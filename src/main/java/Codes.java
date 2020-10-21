import lombok.RequiredArgsConstructor;

public enum Codes
{

    INFORMATIONAL(100, 199),
    SUCCESS(200, 299),
    REDIRECTION(300, 399),
    CLIENT_ERROR(400, 499),
    SERVER_ERROR(500, 599);

    int minCode;
    int maxCode;

    Codes(int min, int max)
    {

    }
}
