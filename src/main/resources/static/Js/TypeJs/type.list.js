var vue = new Vue({
    el: "#pageInfo",
    data: {
        pageInfo: {},
        typeList: {},
    },
    methods: {
        //获取请求页面信息
        getPage: function (pageNum) {
            $.ajax({
                type: 'get',
                url: '/page',
                data: {
                    "pageNum": pageNum,
                },
                success: function (result) {
                    console.log(result.page.list)
                    vue.pageInfo = result.page;
                    vue.typeList = result.page.list;
                }
            })
        },
        edit: function (typeId) {
            window.location.href = "/type_modify?id=" + typeId
        },
        deleteById: function (id) {
            axios({
                url: '/type/' + id,
                method: 'delete',

            }).then(function (result) {
                console.log(result.data);
            })
        }
    },
    mounted: function () {
        this.getPage(1);
    }
})