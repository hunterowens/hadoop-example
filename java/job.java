import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxTemperature {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: MaxTemperature INPUT OUTPUT");
			System.exit(-1);
		}

		Job job = new Job();
		job.setJarByClass(MaxTemperature.class);
		job.setJobName("Max Temperature");

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.addOutputPath(job, new Path(args[1]));

		job.setMapperClass(mapper.class);
		job.setReducerClass(reducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		System.ext(job.waitForCompletion(true) ? 0 : 1);
	}
}