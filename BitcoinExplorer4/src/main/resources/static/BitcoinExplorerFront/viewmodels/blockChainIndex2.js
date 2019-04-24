var app = new Vue({
  el: '#app',
  data: {
    tabledata:[],
    searchData:'',
  },


  mounted(){
   console.log('blockChain Explorer');
  
    this.getTableList();
  
  },
 
  methods:{
 
  getTableList(){
   
      axios.get('http://localhost:8089/block/getRecentBlocks')
      .then(function (response) {
        console.log(response);
        app.tabledata = response.data;
      })
      .catch(function (error) {
        console.log(error);
      })
    },
    
   
    getTableBlocks(){
      location.href="blockChainIndex.html";
  },
  getTableTransactions(){
 
  },



  }
})