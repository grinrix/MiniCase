package minicase.shop;
import minicase.domain.*;

public interface Shop {
    CaseItem buyAndOpen(Profile profile, Case c);
}
