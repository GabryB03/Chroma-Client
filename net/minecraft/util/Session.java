package net.minecraft.util;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;
import java.util.Map;
import java.util.UUID;

public class Session
{
    public String username;
    public String playerID;
    public String token;
    public Session.Type sessionType;

    public Session(String usernameIn, String playerIDIn, String tokenIn, String sessionTypeIn)
    {
        this.username = usernameIn;
        this.playerID = playerIDIn;
        this.token = tokenIn;
        this.sessionType = Session.Type.setSessionType(sessionTypeIn);
    }

    public String getSessionID()
    {
        return "token:" + this.token + ":" + this.playerID;
    }

    public String getPlayerID()
    {
        return this.playerID;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getToken()
    {
        return this.token;
    }

    public GameProfile getProfile()
    {
        try
        {
            UUID uuid = UUIDTypeAdapter.fromString(this.getPlayerID());
            return new GameProfile(uuid, this.getUsername());
        }
        catch (IllegalArgumentException var2)
        {
            return new GameProfile((UUID)null, this.getUsername());
        }
    }

    /**
     * Returns either 'legacy' or 'mojang' whether the account is migrated or not
     */
    public Session.Type getSessionType()
    {
        return this.sessionType;
    }

    public static enum Type
    {
        LEGACY("legacy"),
        MOJANG("mojang");

        private static final Map<String, Session.Type> SESSION_TYPES = Maps.<String, Session.Type>newHashMap();
        private final String sessionType;

        private Type(String sessionTypeIn)
        {
            this.sessionType = sessionTypeIn;
        }

        public static Session.Type setSessionType(String sessionTypeIn)
        {
            return (Session.Type)SESSION_TYPES.get(sessionTypeIn.toLowerCase());
        }

        static {
            for (Session.Type session$type : values())
            {
                SESSION_TYPES.put(session$type.sessionType, session$type);
            }
        }
    }

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setPlayerID(String playerID)
	{
		this.playerID = playerID;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public void setSessionType(Session.Type sessionType)
	{
		this.sessionType = sessionType;
	}
}
