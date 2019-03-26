// CuttingRod
import java.util.*;
import java.io.*;
public class CuttingRod
{
    public static void main(String args[]) throws Exception
	{
        
         Scanner sc=new Scanner(System.in);
		  int x,y,t,n;
          t=sc.nextInt();
		  n=sc.nextInt();
         for(int i=0;i<t;i++)
         {
             x=0;
             y=0;
            if(n!=1)
             {
             while(n!=0)
             {
                 if(n%2==0)
                 {
                     y=1;
                 }
                 if(n==1 && y==1)
                 {
                   x=x-1;
                 }
                n=n/2;
                if(n!=1)
                {
                    x=x+1;
                }
             }
             }
             System.out.println(x);
         }
    }
}

// GlowingBulb
import java.util.*;
import java.io.*;

public class GlowingBulb
{
    static long len;
    static ArrayList<Integer> nums;
    public static void main(String args[] ) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a=br.readLine();
        int N = Integer.parseInt(a);
        while(N-->0)
        {
             String line= br.readLine();
             String ip=br.readLine();
             long z = Long.parseLong(ip);
              nums=new ArrayList();
             int i,j;
             for(i=0;i<40;i++)
             {
                 if(line.charAt(i)=='1')
                 {
                     nums.add(i+1);
                 }
             }
             len=nums.size();
             long t=bins(z);
             System.out.println(t);
        }
    }
    static long bins(long z)
    {
        long l=1; 
		long h=(long)Math.pow(10,15);
		h*=37; long f=0;
        while(l<=h)
        {
            long mid=(l+h)/2;
            long check=call1(mid);
            if(check<z)
            {
                l=mid+1;
            }
            else 
			{
				f=mid;
				h=mid-1;
			}
        }
        return f;
    }
    
    static long call1(long limit)
    {
        int y; long t=0; int n1=1;
        for(y=1;y<(int)Math.pow(2,len);y++)
        {
            int check1=y;
            long m1=1; int nof1=0,ind=0;
            while(check1!=0)
            {
                if((check1&1)>0)
                {
                    m1*=(long)nums.get(ind);
					nof1++;
                }
                
                ind++; 
				check1=check1>>1;
            }
            if(nof1%2==0)
            {
                t-=limit/m1;
            }
            else
            t+=limit/m1;
        }
        return t;
    }
}

// HelpOutIndianArmy
import java.util.*;
import java.io.*;

public class HelpOutIndianArmy
{
    public static void main(String args[]) 
	{
       	Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		long s = sc.nextLong();
		long e = sc.nextLong();
		TreeMap<Long,Long> tree1=new TreeMap<Long,Long>();
		TreeMap<Long,Long> tree2=new TreeMap<Long,Long>();
		for(int i=0;i<n;i++)
		{
			long x = sc.nextLong();
			long y = sc.nextLong();
			tree1.put((x-y),(x+y));
    }
    List<Long> list1=new ArrayList<Long>(tree1.keySet());
    List<Long> list2=new ArrayList<Long>(tree1.values());
    	long p = list1.get(0);
		long q = list2.get(0);
		for(int i=1;i<tree1.size();i++)
		{
			if(list1.get(i)<=q)
				q= Math.max(q,list2.get(i));
			else
			{
				
				tree2.put(p,q);
				p = list1.get(i);
				q= list2.get(i);
			}
			
		}
		tree2.put(p,q);
	 	int i;
		long a = 0;
    list1=new ArrayList<Long>(tree2.keySet());
    list2=new ArrayList<Long>(tree2.values());
		for(i=0;i<list1.size();i++)
		{
			if(s>=e)
			{
				s=e;
				break;
			}
			if(list1.get(i)<=s && s<=list2.get(i))
				s = list2.get(i);
			else if(s<=list1.get(i) && e>=list2.get(i))
			{
				a+=list1.get(i)-s;
				s = list2.get(i);
				
			}
			else if(s<=list1.get(i) && e>=list1.get(i) &&  e<=list2.get(i))
			{
				a+=list1.get(i)-s;
				s = e;
			}
			else if(s<=list1.get(i) && e<=list1.get(i))
			{
				a+=e-s;
				s = e;
			}
		}
		if(s<e)
			a+=e-s;
		System.out.println(a);
	}
}

// MetroClass
import java.util.*;
import java.io.*;

public class MetroClass
 {
	static Scanner sc=new Scanner(System.in);
        public static void main(String[] args)  {
            Metro solver = new Metro();
            solver.solve();
        }
        static class Metro {
            public void solve() {
                int n = sc.nextInt();
                int m = sc.nextInt();
                ArrayList<pair> arrayList[] = new ArrayList[n + 1];
                for (int i = 0; i <= n; i++) arrayList[i] = new ArrayList();
                for (int i = 0; i < m; i++) {
                    int s = sc.nextInt();
                    long t = sc.nextLong();
                    int arr[] = new int[s];
                    for (int j = 0; j < s; j++) arr[j] = sc.nextInt();
                    for (int j = 0; j < s - 1; j++) {
                        int we = sc.nextInt();
                        arrayList[arr[j]].add(new pair(arr[j + 1], we,t));
                        t += we;
                    }
                }
                int st = sc.nextInt();
                int end = sc.nextInt();
                long dis[] = new long[n + 1];
                Arrays.fill(dis, Long.MAX_VALUE / 2);
                dis[st] = 0;
                PriorityQueue<pair2> pq = new PriorityQueue<>(new Comparator<pair2>() {
                    public int compare(pair2 o1, pair2 o2) {
                        return Long.compare(o1.dis, o2.dis);
                    }
                });
                pq.add(new pair2(st, dis[st]));
                boolean visited[] = new boolean[n + 1];
                visited[st] = true;
                while (!pq.isEmpty()) {
                    pair2 p = pq.poll();
                    if (p.node == end) {
                        System.out.println(dis[p.node]);
                        return;
                    }
                    for (pair pp : arrayList[p.node]) {
                        if (dis[p.node] <= pp.t && dis[pp.u] > dis[p.node] + pp.w) {
                            dis[pp.u] = dis[p.node] + pp.w;
                            pq.add(new pair2(pp.u, dis[pp.u]));
                        }
                    }
                }
                System.out.println(-1);
            }
            class pair2 {
                int node;
                long dis;
     
                public pair2(int node, long dis) {
                    this.node = node;
                    this.dis = dis;
                }
            }
            class pair {
                int u;
                long w;
                long t;
     
                public pair(int u, long w, long t) {
                    this.u = u;
                    this.w = w;
                    this.t = t;
                }
            }
        }
    }
	
  // StatisticsofString
  
 import java.util.*;
 import java.io.*;
public class StatisticsofString
{
	static int pow(int a, int b, int m) 
	{
		if (b == 0)
			return 1;
		int p = pow(a, b / 2, m);
		p = (int) ((long) p * p % m);
		if (b % 2 == 1)
			p = (int) ((long) p * a % m);
		return p;
	}
	static int[] d;
	static int find(int i) {
		return d[i] < 0 ? i : (d[i] = find(d[i]));
	}
	static boolean join(int i, int j) {
		i = find(i);
		j = find(j);
		if (i == j)
			return false;
		if (d[i] > d[j])
			d[i] = j;
		else {
			if (d[i] == d[j])
				d[i]--;
			d[j] = i;
		}
		return true;
	}
	static int s_(int k, int v, int n, int a, int m) {
		Arrays.fill(d, -1);
		int bcnt = 0, cnt = n;
		for (int i = 1; i < n; i++)
			if ((v & 1 << i) > 0) {
				for (int j = i; j < i + k; j++)
					if (join(j, j - i))
						cnt--;
				bcnt++;
			}
		int sum = pow(a, cnt, m);
		return bcnt % 2 == 1 ? sum : (m - sum) % m;
	}
	static int solve(int n, int a, int m) {
		d = new int[n];
		int s = 0;
		for (int k = 1; k < n; k++)
			for (int v = 2; v < 1 << n - k + 1; v += 2)
				s = (s + s_(k, v, n, a, m)) % m;
		return s;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		System.out.println(solve(n, a, m));
	}
}

// DescendingWeight
import java.util.*;
import java.io.*;

public class DescendingWeight
{
    public static void main(String args[] ) throws Exception 
	{
        Scanner  sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=sc.nextInt();
        int []ar=new int[n];
        List<Integer>[] weights = (List<Integer>[]) new List[a];
        for (int i=0; i < a; i++)
            weights[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            ar[i] = v;
            int w = v % a;
            weights[w].add(v);
        }
 
        for (int i = a-1; i >= 0; i--) {
            Collections.sort(weights[i]);
            for (int j = 0; j < weights[i].size(); j++) {
                System.out.print(weights[i].get(j));
                System.out.print(" ");
            }
        }
    }
}