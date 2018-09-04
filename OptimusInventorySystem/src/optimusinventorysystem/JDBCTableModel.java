/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package optimusinventorysystem;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
	
	public class JDBCTableModel extends AbstractTableModel {
		Object[][] contents;
		String[] columnNames;
		Class[] columnClasses;
                String[] tableNames={"TABLE"};
                DatabaseMetaData meta;

                public JDBCTableModel(Connection conn1)throws SQLException
                {
                    meta = conn1.getMetaData();
                    getDatabaseContents();
                }
		public JDBCTableModel(Connection conn,String tableName)throws SQLException
		{
			super();
                        meta = conn.getMetaData();
			getTableContents(conn, tableName);
		}
                protected  void getDatabaseContents()throws SQLException
                {
               
                ArrayList tableNamesList = new ArrayList();
                ResultSet results = meta.getTables(null, null, null, tableNames);
                while (results.next())
                {
                /*getting the names of database tables*/
                tableNamesList.add (results.getString ("TABLE_NAME"));
                }
                tableNames = new String [tableNamesList.size()];
		tableNamesList.toArray (tableNames);
                }

		protected void getTableContents(Connection conn,String tableName)throws SQLException
		{
                    
		ResultSet results1 = meta.getColumns (null, null, tableName, null) ;
		
		ArrayList colNamesList = new ArrayList();
		ArrayList colClassesList = new ArrayList();
		while (results1.next())
		{
			colNamesList.add (results1.getString ("COLUMN_NAME"));
			results1.getString ("COLUMN_NAME");
			int dbType = results1.getInt ("DATA_TYPE");
			switch (dbType)
			{
			case Types.INTEGER:
		colClassesList.add (Integer.class); break;
			case Types.FLOAT:
		colClassesList.add (Float.class); break;
			case Types.DOUBLE:
			case Types.REAL:
		colClassesList.add (Double.class); break;
			case Types.DATE:
			case Types.TIME:
			case Types.TIMESTAMP:
		colClassesList.add (java.sql.Date.class); break;
			default:
		colClassesList.add (String.class); break;
			};
			results1.getInt ("DATA_TYPE");

		}
			columnNames = new String [colNamesList.size()];
			colNamesList.toArray (columnNames);
			columnClasses = new Class [colClassesList.size()];
			colClassesList.toArray (columnClasses);

			//Statement statement = conn.createStatement ();
                        System.out.println(ViewProductDetail.prodcat.toString());
                        PreparedStatement ps=conn.prepareStatement("select * from productdetails where product_id=(select Product_id from productmaster where Product_Type=?)");
                        ps.setString(1,ViewProductDetail.prodcat.toString());
			results1 = ps.executeQuery();
			ArrayList rowList = new ArrayList();
			while (results1.next())
			{
				ArrayList cellList = new ArrayList();
				for (int i = 0; i<columnClasses.length; i++)
				{
					Object cellValue = null;

					if (columnClasses[i] == String.class)
						cellValue = results1.getString (columnNames[i]);
					else if (columnClasses[i] == Integer.class)
					cellValue = new Integer (
					results1.getInt (columnNames[i]));
					else if (columnClasses[i] == Float.class)
					cellValue = new Float (
					results1.getInt (columnNames[i]));
					else if (columnClasses[i] == Double.class)
					cellValue = new Double (
					results1.getDouble (columnNames[i]));
					else if (columnClasses[i] == java.sql.Date.class)
					cellValue = results1.getDate (columnNames[i]);
					else
					System.out.println ("Can't assign " + columnNames[i]);
					cellList.add (cellValue);
				}// for
		Object[] cells = cellList.toArray();
		rowList.add (cells);

	} 
	contents = new Object[rowList.size()] [];
	for (int i=0; i<contents.length; i++)
	{
		contents[i] = (Object []) rowList.get (i);	
	}
	results1.close();
	ps.close();

	}
	public int getRowCount() {
		return contents.length;
	}
	public int getColumnCount() {
		if (contents.length == 0)
			return 0;
		else
			return contents[0].length;
		}

		public Object getValueAt (int row, int column) {
			return contents [row][column];
		}

		public Class getColumnClass (int col) {
			return columnClasses [col];
		}

		public String getColumnName (int col) {
			return columnNames [col];
		}
	}