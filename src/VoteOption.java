import java.util.Objects;

public class VoteOption
{
    private String name;

    public VoteOption(String name)
    {
        this.name = name;
    }

    public VoteOption()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "VoteOption{" + "name='" + name + '}';
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteOption that = (VoteOption) o;

        return this.name.compareToIgnoreCase(that.name) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name.toLowerCase());
    }
}
