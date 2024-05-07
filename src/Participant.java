import java.util.Objects;

public class Participant extends VoteOption
{
    private String sign;
    private String party;

    public Participant(String name, String sign, String party)
    {
        super(name);
        this.sign = sign;
        this.party = party;
    }

    public Participant()
    {

    }

    public String getSign()
    {
        return sign;
    }

    public void setSign(String sign)
    {
        this.sign = sign;
    }

    public String getParty()
    {
        return party;
    }

    public void setParty(String party)
    {
        this.party = party;
    }

    @Override
    public String toString()
    {
        return "Participant{" + super.toString() + '\'' + ", sign='" + sign + '\'' + ", party='" + party + '\'' + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Participant that = (Participant) o;
        return this.sign.compareToIgnoreCase(that.sign) == 0 && this.party.compareToIgnoreCase(that.party) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), sign, party);
    }
}
