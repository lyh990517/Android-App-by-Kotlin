package yunho.app.basiccalculator.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import yunho.app.basiccalculator.model.history;

@SuppressWarnings({"unchecked", "deprecation"})
public final class historyDAO_Impl implements historyDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<history> __insertionAdapterOfhistory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public historyDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfhistory = new EntityInsertionAdapter<history>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `history` (`uid`,`expression`,`result`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, history value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getUid());
        }
        if (value.getExpression() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getExpression());
        }
        if (value.getResult() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getResult());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM history";
        return _query;
      }
    };
  }

  @Override
  public void insertHistory(final history history) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfhistory.insert(history);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<history> getAll() {
    final String _sql = "SELECT * FROM history";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfExpression = CursorUtil.getColumnIndexOrThrow(_cursor, "expression");
      final int _cursorIndexOfResult = CursorUtil.getColumnIndexOrThrow(_cursor, "result");
      final List<history> _result = new ArrayList<history>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final history _item;
        final Integer _tmpUid;
        if (_cursor.isNull(_cursorIndexOfUid)) {
          _tmpUid = null;
        } else {
          _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        }
        final String _tmpExpression;
        _tmpExpression = _cursor.getString(_cursorIndexOfExpression);
        final String _tmpResult;
        _tmpResult = _cursor.getString(_cursorIndexOfResult);
        _item = new history(_tmpUid,_tmpExpression,_tmpResult);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
