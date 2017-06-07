package co.chatsdk.core.dao;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.converter.PropertyConverter;
import org.joda.time.DateTime;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.json.JSONException;
import org.json.JSONObject;

import co.chatsdk.core.interfaces.CoreEntity;

@org.greenrobot.greendao.annotation.Entity
public class BMessage implements CoreEntity {

    public static final class Type{
        public static final int TEXT = 0, IMAGE = 2, LOCATION = 1;
    }

    public static final class Status{
        public static final int NULL = 0, SENDING = 1, SENT = 2, FAILED = 3;
    }

    public static final class Delivered{
        public static final int Yes = 0, No= 1;
    }

    // TODO: test how this handles timezones
    public static class DateTimeConverter implements PropertyConverter<DateTime, Long> {
        @Override
        public DateTime convertToEntityProperty(Long databaseValue) {
            if (databaseValue == null) {
                return null;
            }

            return new DateTime(databaseValue);
        }

        @Override
        public Long convertToDatabaseValue(DateTime dateTime) {
            return dateTime == null ? null : dateTime.getMillis();
        }
    }

    @Id
    private Long id;
    private String entityID;

    @Convert(converter = DateTimeConverter.class, columnType = Long.class)
    private DateTime date;
    private Boolean isRead;
    private String resources;
    private String resourcesPath;
    private String text;
    private String imageDimensions;
    private Integer type;
    private Integer status;
    private Integer delivered;
    private Long senderId;
    private Long threadId;

    @ToOne(joinProperty = "senderId")
    private BUser Sender;


    @ToOne(joinProperty = "threadId")
    private BThread thread;

    @Transient
    public static final String TAG = BMessage.class.getSimpleName();
    //@Transient
    //public static final boolean DEBUG = Debug.BMessage;
    @Transient
    public String color = null;
    @Transient
    public String fontName = null;
    @Transient
    public String textColor = null;
    @Transient
    public int fontSize = -1;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1248547475)
    private transient BMessageDao myDao;
    @Generated(hash = 1974258785)
    private transient Long thread__resolvedKey;
    @Generated(hash = 1667105234)
    private transient Long Sender__resolvedKey;



    @Generated(hash = 1345507635)
    public BMessage(Long id, String entityID, DateTime date, Boolean isRead, String resources, String resourcesPath, String text, String imageDimensions, Integer type, Integer status, Integer delivered, Long senderId, Long threadId) {
        this.id = id;
        this.entityID = entityID;
        this.date = date;
        this.isRead = isRead;
        this.resources = resources;
        this.resourcesPath = resourcesPath;
        this.text = text;
        this.imageDimensions = imageDimensions;
        this.type = type;
        this.status = status;
        this.delivered = delivered;
        this.senderId = senderId;
        this.threadId = threadId;
    }

    @Generated(hash = 1345317104)
    public BMessage() {
    }

    public String color() {
        return getSender().getMessageColor();
    }

    public Integer getStatusOrNull(){
        if (status == null)
            status = Status.NULL;

        return status;
    }
    
    public int wasDelivered(){
       return delivered == null ?  Delivered.Yes :  delivered;
        
    }

    /** Null safe version of getIsRead*/
    public boolean wasRead(){
        return isRead==null || isRead;
    }

    @Override
    public String toString() {
        return String.format("BMessage, id: %s, type: %s, Sender: %s", id, type, getSender());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityID() {
        return this.entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public DateTime getDate() {
        return this.date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Boolean getIsRead() {
        return this.isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public String getResources() {
        return this.resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getResourcesPath() {
        return this.resourcesPath;
    }

    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public String getRawJSONPayload() {
        return this.text;
    }

    public void setRawJSONPayload (String payload) {
        this.text = payload;
    }

    public Object valueForKey (String key) {
        String json = getRawJSONPayload();
        if(json == null || json.length() == 0 ) {
            return "";
        }
        try {
            return new JSONObject(getRawJSONPayload()).get(key);
        }
        catch (JSONException e) {
            return new JSONObject();
        }
    }

    public void setValueForKey (Object payload, String key) {
        try {
            String jsonString = getRawJSONPayload();
            JSONObject json = jsonString != null ? new JSONObject(jsonString) : new JSONObject();

            json.put(key, payload);
            setRawJSONPayload(json.toString());
        }
        catch (JSONException e) {
        }
    }

    public String getText() {
        return valueForKey(DaoDefines.Keys.MessageText).toString();
    }

    public void setText(String text) {
        setValueForKey(text, DaoDefines.Keys.MessageText);
    }

    public String getImageDimensions() {
        return this.imageDimensions;
    }

    public void setImageDimensions(String imageDimensions) {
        this.imageDimensions = imageDimensions;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    // TODO: Refactor this to be a bool
    @Deprecated
    public Integer getDelivered() {
        return delivered == null ? Delivered.No : delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
    }

    public Long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public Long getSenderId() {
        return this.senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 245464515)
    public BUser getSender() {
        Long __key = this.senderId;
        if (Sender__resolvedKey == null || !Sender__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BUserDao targetDao = daoSession.getBUserDao();
            BUser SenderNew = targetDao.load(__key);
            synchronized (this) {
                Sender = SenderNew;
                Sender__resolvedKey = __key;
            }
        }
        return Sender;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1850943564)
    public void setSender(BUser Sender) {
        synchronized (this) {
            this.Sender = Sender;
            senderId = Sender == null ? null : Sender.getId();
            Sender__resolvedKey = senderId;
        }
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 198122087)
    public BThread getThread() {
        Long __key = this.threadId;
        if (thread__resolvedKey == null || !thread__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BThreadDao targetDao = daoSession.getBThreadDao();
            BThread threadNew = targetDao.load(__key);
            synchronized (this) {
                thread = threadNew;
                thread__resolvedKey = __key;
            }
        }
        return thread;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1616164599)
    public void setThread(BThread thread) {
        synchronized (this) {
            this.thread = thread;
            threadId = thread == null ? null : thread.getId();
            thread__resolvedKey = threadId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1425244845)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBMessageDao() : null;
    }



}
