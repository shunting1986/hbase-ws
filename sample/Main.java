package sample;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.util.Bytes;

public class Main {
	public static void main(String[] args) throws Exception {
		Configuration conf = HBaseConfiguration.create();
		HTable table = new HTable(conf, "zstable");

		List<Get> list = new ArrayList<Get>();

		Get get = new Get(Bytes.toBytes("row1"));
		get.addFamily(Bytes.toBytes("G"));
		get.setMaxVersions();
		list.add(get);
		
		get = new Get(Bytes.toBytes("row2"));
		list.add(get);

		Result[] reslist = table.get(list);
		for (Result res : reslist) {
			System.out.println(res);
		}
		System.out.println("+ DONE");
	}
}
