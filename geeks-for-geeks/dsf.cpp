#include <iostream>
#include <queue>
#include <vector>
#include <list>

bool vis[100001];
std::vector<int> g[100001];

void dfs(int s,std::vector<int> adj[],bool vis[]);

int main()
{
    int T;
    std::cin>>T;
    while(T--)
    {


        memset(g,0,sizeof g);
        memset(vis,false,sizeof vis);

        int N;
        std::cin>>N;
        for(int i=0;i<N;i++)
        {
            int u,v;
            std::cin>>u>>v;
            g[u].push_back(v);

        }


        dfs(1,g,vis);
        std::cout<<std::endl;

    }
}

/* You have to complete this function
which prints out the breadth first level traversal of the 
graph starting from node s
the vector<int> g[i] represent the adjacency 
list of the ith node of the graph
 */
void dfs(int s, std::vector<int> g[], bool vis[])
{
 
    vis[s] = true;
    std::cout << s << " ";
    
    std::vector<int>::iterator i;
    
    for(i = g[s].begin(); i != g[s].end(); ++i)
    {
        if(!vis[*i])
        {
            vis[*i] = true;
            dfs(*i,g,vis);
        }
    }
}