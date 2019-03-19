package util.xmlCollectionUtil;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Set;

@XmlType
public class Type1 {
    private Set<String> cardNumbers;

    @XmlElement
    public Set<String> getCardNumbers() {
        return this.cardNumbers;
    }

    public void setCardNumbers(Set<String> cardNumbers) {
        this.cardNumbers = cardNumbers;
    }
}
