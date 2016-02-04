import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class aaq extends SQLiteOpenHelper {
    public aaq(Context context) {
        super(context, "DbSystem", null, 3);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(" create table GroupTbl ( _id string  ,GroupName text,FK_CreatorUserId integer,CreatorNumber text,CreateDate text,FK_AdminUserId integer,status integer,Image text,NumberOfUnread integer,AdminNumber text ); ");
        sQLiteDatabase.execSQL(" create table Message(_id integer primary key  autoincrement ,PK_MessageId integer,TextOfMessage text,StickyImageId integer,AttachmentType text,status integer,AttachmentSize integer,AttachmentValue text);");
        sQLiteDatabase.execSQL(" create table SendReceive(_id integer primary key  autoincrement ,SendReceiveId integer,FK_MessageId integer,FK_ClientMessageId integer,SenderMobile text,ReciverIsUser integer,FK_ReceiverId integer,ReceiverMobile text,ServerReceived integer,ServerReceiveDate text,Delivered integer,DeliverDate text,Seen integer,SeenDate text,status integer,CountUserOfGroupSeen integer);");
        sQLiteDatabase.execSQL(" create table Users(_id integer primary key  autoincrement ,MobileNumber text,CreateDate text,LastSeen text,LastImageUrl text,NickName text,status integer,NumberOfUnread integer,FullImageUrl text);");
        sQLiteDatabase.execSQL(" create table logError(_id integer primary key  autoincrement ,applicationName text,errorMsg text,errorLocation text,createDate text,deviceSn text,senT integer );");
        sQLiteDatabase.execSQL(" create table GroupUser ( _id integer primary key  autoincrement ,PK_GroupId integer,MobileNumber text,NickName text,Image text,status text  ); ");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.w(aaq.class.getName(), "Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        if (i2 > i) {
            sQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN AttachmentSize INTEGER DEFAULT -1");
            sQLiteDatabase.execSQL(" Update Message Set AttachmentSize =  -1 ");
        }
    }
}
