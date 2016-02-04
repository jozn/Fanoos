import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class za {
    Context a;
    private SQLiteDatabase b;
    private aaq c;
    private String[] d;

    public za(Context context) {
        this.d = new String[]{"status", "TextOfMessage", "_id", "PK_MessageId", "StickyImageId", "AttachmentType", "AttachmentValue", "AttachmentSize"};
        this.c = new aaq(context);
        this.a = context;
    }

    public void a() {
        this.b = this.c.getWritableDatabase();
    }

    public void b() {
        this.c.close();
        this.b.close();
    }

    public yz a(Long l) {
        Cursor query = this.b.query("Message", this.d, "_id=?", new String[]{String.valueOf(l)}, null, null, null);
        query.moveToFirst();
        yz yzVar = new yz();
        if (query.getCount() > 0) {
            yzVar = a(query);
        } else {
            yzVar.a(String.valueOf(-1));
        }
        query.close();
        return yzVar;
    }

    public yz a(Cursor cursor) {
        yz yzVar = new yz();
        yzVar.c(cursor.getInt(cursor.getColumnIndex("status")));
        yzVar.b(cursor.getString(cursor.getColumnIndex("TextOfMessage")));
        yzVar.a(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))));
        yzVar.a(cursor.getString(cursor.getColumnIndex("PK_MessageId")));
        yzVar.b(cursor.getInt(cursor.getColumnIndex("StickyImageId")));
        yzVar.c(cursor.getString(cursor.getColumnIndex("AttachmentType")));
        yzVar.d(cursor.getString(cursor.getColumnIndex("AttachmentValue")));
        yzVar.a(cursor.getInt(cursor.getColumnIndex("AttachmentSize")));
        return yzVar;
    }

    public List a(String str) {
        HashMap hashMap = new HashMap();
        Cursor rawQuery = this.b.rawQuery("select NickName,MobileNumber from Users", null);
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            hashMap.put(rawQuery.getString(1), rawQuery.getString(0));
            rawQuery.moveToNext();
        }
        rawQuery.close();
        List arrayList = new ArrayList();
        Cursor rawQuery2 = this.b.rawQuery("select * from (\n select  users.LastImageUrl as images ,users.NumberOfUnread as NumberOfUnread , FK_ClientMessageId,  M.TextOfMessage as TextOfMessage ,M.AttachmentType as AttachmentType ,  tbl1.ReceiverMobile as ReceiverMobile, users.NickName as NickName , tbl1.ReciverIsUser as ReciverIsUser,tbl1.FK_ReceiverId as FK_ReceiverId,tbl1.ReceiveDate as ReceiveDate   from Message M inner join\n                    (Select SendReceive.FK_ClientMessageId as FK_ClientMessageId, Max (SendReceive.FK_ClientMessageId) as MSGId ,sendReceive.ServerReceiveDate as ReceiveDate ,sendReceive.ReceiverMobile as ReceiverMobile ,sendReceive.ReciverIsUser as ReciverIsUser ,sendReceive.FK_ReceiverId as FK_ReceiverId   from SendReceive Group by SendReceive.ReceiverMobile , sendReceive.ReciverIsUser  ) as tbl1\n                          on M._id=tbl1.MSGId \n                          inner join users\n                            on tbl1.ReceiverMobile=users.MobileNumber\n                         where ReciverIsUser=0 and  \n  ( NickName like  '" + str + "%' OR NickName like '% " + str + "%')" + " " + "               \n" + "                             UNION All \n" + "                           select groupTbl.image as images , groupTbl.NumberOfUnread as NumberOfUnread , FK_ClientMessageId , M.TextOfMessage as TextOfMessage , M.AttachmentType as AttachmentType , tbl1.ReceiverMobile as ReceiverMobile, groupTbl.GroupName as NickName , tbl1.ReciverIsUser as ReciverIsUser,tbl1.FK_ReceiverId as FK_ReceiverId ,tbl1.ReceiveDate as ReceiveDate from Message M inner join\n" + "                            (Select SendReceive.FK_ClientMessageId as FK_ClientMessageId, Max (SendReceive.FK_ClientMessageId) as MSGId ,sendReceive.ServerReceiveDate as ReceiveDate ,sendReceive.ReceiverMobile as ReceiverMobile ,sendReceive.ReciverIsUser as ReciverIsUser ,sendReceive.FK_ReceiverId as FK_ReceiverId from SendReceive Group by SendReceive.FK_ReceiverId) as tbl1\n" + "                           on M._id=tbl1.MSGId \n" + "                             inner join groupTbl \n" + "                           on groupTbl._id=tbl1.FK_ReceiverId \n" + "                )as tbl2 \n" + " where ( NickName like " + " '" + str + "%' OR NickName like '% " + str + "%')" + "                order by tbl2.FK_ClientMessageId  desc", null);
        rawQuery2.moveToFirst();
        String o = aeq.o(this.a);
        while (!rawQuery2.isAfterLast()) {
            zd b = b(rawQuery2);
            if (b.e().startsWith(zh.e + zh.d)) {
                b.h(a(hashMap, o, b.i()));
            }
            arrayList.add(b);
            rawQuery2.moveToNext();
        }
        rawQuery2.close();
        return arrayList;
    }

    public zd b(Cursor cursor) {
        zd zdVar = new zd();
        zdVar.e(cursor.getString(cursor.getColumnIndex("NickName")));
        zdVar.d(cursor.getString(cursor.getColumnIndex("ReceiverMobile")));
        zdVar.h(cursor.getString(cursor.getColumnIndex("TextOfMessage")));
        zdVar.c(cursor.getString(cursor.getColumnIndex("FK_ReceiverId")));
        zdVar.b(cursor.getString(cursor.getColumnIndex("ReciverIsUser")));
        zdVar.f(cursor.getString(cursor.getColumnIndex("images")));
        zdVar.a(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("NumberOfUnread"))));
        zdVar.a(cursor.getString(cursor.getColumnIndex("AttachmentType")));
        zdVar.g(cursor.getString(cursor.getColumnIndex("ReceiveDate")));
        return zdVar;
    }

    public List a(String str, int i) {
        List arrayList = new ArrayList();
        Cursor rawQuery = this.b.rawQuery(" select  SR.SendReceiveId as SRSendReceiveId, SR._id as SR_id, SR.ReceiverMobile as SRReceiverMobile, SR.FK_ClientMessageId as SRFK_ClientMessageId, SR.FK_MessageId as SRFK_MessageId, SR.CountUserOfGroupSeen as SRCountUserOfGroupSeen, SR.DeliverDate as SRDeliverDate, SR.ServerReceiveDate as SRServerReceiveDate, SR.Delivered as SRDelivered, SR.Seen as SRSeen, SR.SeenDate as SRSeenDate, SR.status as SRstatus, SR.ReciverIsUser as SRReciverIsUser, SR.SenderMobile as SRSenderMobile, SR.FK_ReceiverId as SRFK_ReceiverId, M._id as M_id, M.PK_MessageId as MPK_MessageId, M.TextOfMessage as MTextOfMessage, M.status as Mstatus, M.AttachmentType as MAttachmentType, M.AttachmentSize as MAttachmentSize, U.LastImageUrl as ULastImageUrl from Message M  inner join SendReceive SR  on  M._id =  SR.FK_ClientMessageId inner join Users U on SR.ReceiverMobile =  U.MobileNumber where SRReceiverMobile like \"%" + str + "%\"" + " and  " + "SR" + "ReciverIsUser" + " = " + "0" + " order by  " + "SR." + "_id" + " desc " + " limit " + i, null);
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            arrayList.add(c(rawQuery));
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return arrayList;
    }

    public List b(String str, int i) {
        HashMap hashMap = new HashMap();
        Cursor rawQuery = this.b.rawQuery("select NickName,MobileNumber from Users", null);
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            hashMap.put(rawQuery.getString(1), rawQuery.getString(0));
            rawQuery.moveToNext();
        }
        rawQuery.close();
        List arrayList = new ArrayList();
        Cursor rawQuery2 = this.b.rawQuery(" select   distinct  SR.SendReceiveId as SRSendReceiveId, SR._id as SR_id, SR.ReceiverMobile as SRReceiverMobile, SR.FK_ClientMessageId as SRFK_ClientMessageId, SR.FK_MessageId as SRFK_MessageId, SR.CountUserOfGroupSeen as SRCountUserOfGroupSeen, SR.DeliverDate as SRDeliverDate, SR.ServerReceiveDate as SRServerReceiveDate, SR.Delivered as SRDelivered, SR.Seen as SRSeen, SR.SeenDate as SRSeenDate, SR.status as SRstatus, SR.ReciverIsUser as SRReciverIsUser, SR.SenderMobile as SRSenderMobile, M.AttachmentType as MAttachmentType, SR.FK_ReceiverId as SRFK_ReceiverId, M._id as M_id, M.PK_MessageId as MPK_MessageId, M.TextOfMessage as MTextOfMessage, M.status as Mstatus, M.AttachmentType as MAttachmentType, M.AttachmentSize as MAttachmentSize, U.NickName as UNickName, GU.NickName as GUNickName, GU.Image as GUImage from Message M  inner join SendReceive SR  on  M._id =  SR.FK_ClientMessageId left join GroupUser GU  on  SR.ReceiverMobile =  GU.MobileNumber left join Users U  on  SR.ReceiverMobile =  U.MobileNumber where SRFK_ReceiverId = '" + str + "'" + " order by  " + "SR." + "_id" + " desc " + " limit " + i, null);
        rawQuery2.moveToFirst();
        String o = aeq.o(this.a);
        while (!rawQuery2.isAfterLast()) {
            zc d = d(rawQuery2);
            if (d.k().startsWith(zh.e + zh.d)) {
                d.d(a(hashMap, o, d.d()));
            }
            arrayList.add(d);
            rawQuery2.moveToNext();
        }
        rawQuery2.close();
        return arrayList;
    }

    public static String a(HashMap hashMap, String str, String str2) {
        String[] split = str2.split(" ");
        if (split.length <= 0) {
            return str2;
        }
        if (split[0].equals(str)) {
            str2 = str2.replace(str, "\u0634\u0645\u0627 ") + "\u06cc\u062f";
        }
        int length = split.length;
        int i = 0;
        String str3 = str2;
        while (i < length) {
            String replace;
            CharSequence charSequence = split[i];
            if (charSequence.contains(str)) {
                replace = str3.replace(str, "\u0634\u0645\u0627 ");
            } else {
                replace = str3;
            }
            if (hashMap.containsKey(charSequence)) {
                replace = replace.replace(charSequence, (CharSequence) hashMap.get(charSequence));
            }
            i++;
            str3 = replace;
        }
        return str3;
    }

    public zc c(Cursor cursor) {
        zc zcVar = new zc();
        zcVar.f(cursor.getString(cursor.getColumnIndex("SRSendReceiveId")));
        zcVar.b(Long.valueOf(cursor.getLong(cursor.getColumnIndex("SR_id"))));
        zcVar.c(cursor.getString(cursor.getColumnIndex("MPK_MessageId")));
        zcVar.a(Long.valueOf(cursor.getLong(cursor.getColumnIndex("M_id"))));
        zcVar.d(cursor.getString(cursor.getColumnIndex("MTextOfMessage")));
        zcVar.c(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("SRDelivered"))));
        zcVar.f(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("SRCountUserOfGroupSeen"))));
        zcVar.i(cursor.getString(cursor.getColumnIndex("SRServerReceiveDate")));
        zcVar.j(cursor.getString(cursor.getColumnIndex("SRDeliverDate")));
        zcVar.h(cursor.getString(cursor.getColumnIndex("SRReceiverMobile")));
        zcVar.c(Long.valueOf(cursor.getLong(cursor.getColumnIndex("SRFK_ReceiverId"))));
        zcVar.b(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("SRReciverIsUser"))));
        zcVar.d(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("SRSeen"))));
        zcVar.k(cursor.getString(cursor.getColumnIndex("SRSeenDate")));
        zcVar.a(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("Mstatus"))));
        zcVar.e(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("SRstatus"))));
        zcVar.g(cursor.getString(cursor.getColumnIndex("SRSenderMobile")));
        zcVar.e(cursor.getString(cursor.getColumnIndex("MAttachmentType")));
        zcVar.a(cursor.getInt(cursor.getColumnIndex("MAttachmentSize")));
        zcVar.a(cursor.getString(cursor.getColumnIndex("ULastImageUrl")));
        return zcVar;
    }

    public zc d(Cursor cursor) {
        zc zcVar = new zc();
        zcVar.f(cursor.getString(cursor.getColumnIndex("SRSendReceiveId")));
        zcVar.b(Long.valueOf(cursor.getLong(cursor.getColumnIndex("SR_id"))));
        zcVar.c(cursor.getString(cursor.getColumnIndex("MPK_MessageId")));
        zcVar.a(Long.valueOf(cursor.getLong(cursor.getColumnIndex("M_id"))));
        zcVar.d(cursor.getString(cursor.getColumnIndex("MTextOfMessage")));
        zcVar.c(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("SRDelivered"))));
        zcVar.f(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("SRCountUserOfGroupSeen"))));
        zcVar.i(cursor.getString(cursor.getColumnIndex("SRServerReceiveDate")));
        zcVar.j(cursor.getString(cursor.getColumnIndex("SRDeliverDate")));
        zcVar.h(cursor.getString(cursor.getColumnIndex("SRReceiverMobile")));
        zcVar.c(Long.valueOf(cursor.getLong(cursor.getColumnIndex("SRFK_ReceiverId"))));
        zcVar.b(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("SRReciverIsUser"))));
        zcVar.d(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("SRSeen"))));
        zcVar.k(cursor.getString(cursor.getColumnIndex("SRSeenDate")));
        zcVar.a(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("Mstatus"))));
        zcVar.e(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("SRstatus"))));
        zcVar.g(cursor.getString(cursor.getColumnIndex("SRSenderMobile")));
        zcVar.e(cursor.getString(cursor.getColumnIndex("MAttachmentType")));
        zcVar.a(cursor.getInt(cursor.getColumnIndex("MAttachmentSize")));
        if (cursor.getString(cursor.getColumnIndex("UNickName")) != null) {
            zcVar.b(cursor.getString(cursor.getColumnIndex("UNickName")));
        } else {
            zcVar.b(cursor.getString(cursor.getColumnIndex("GUNickName")));
        }
        zcVar.a(cursor.getString(cursor.getColumnIndex("GUImage")));
        return zcVar;
    }
}
