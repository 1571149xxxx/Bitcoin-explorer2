var app = new Vue({
    el: '#app',
    data: {
      tabledata:[]
    },
    mounted(){
    this.getBlockDetailList();
    },
    methods:{
      getBlockDetailList(){
        axios.get('http://localhost:8089/block/blockViewMore')
        .then(function (response) {
          console.log(response);
          app.tabledata = response.data;
        })
        .catch(function (error) {
          console.log(error);
        })
      }


      }
    
  })