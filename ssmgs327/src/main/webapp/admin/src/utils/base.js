const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmgs327/",
            name: "ssmgs327",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmgs327/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "选课系统小程序"
        } 
    }
}
export default base
