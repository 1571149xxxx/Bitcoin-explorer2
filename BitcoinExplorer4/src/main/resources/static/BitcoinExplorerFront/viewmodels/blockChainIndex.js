var app = new Vue({
    el: '#app',
    data: {
      tabledata:[],
      searchData:'',
      controlTable:'block'
    },
    computed:{
   
      showRecentBlocks(){
          var now = Date.now();
          this.tabledata.forEach(block => {
              block.showtime = parseInt((now - block.time)/1000/60);
              if(block.showtime%3600>=1){
                block.showtime = parseInt(block.showtime/(24*60))+" day "+parseInt(block.showtime%(60*24)/60)+" hours "+parseInt(block.showtime%(60*24)%60)+" minutes";
              }
              block.showsizeOnDisk = block.sizeOnDisk.toLocaleString('en');
          });
          
          return this.tabledata;
      }
  },

    mounted(){
     console.log('blockChain Explorer');
    
      this.getTableList();
    

    },
   
    methods:{
    //   handleConnect() {
    //     console.log('connect click');
    //     ws = new WebSocket('ws://localhost:8089/bbb');
    //     ws.onmessage = function (frame) {
    //         console.log(frame.data);
    //     }
    // },
    // handleSend() {
    //     console.log('send click');
    //     ws.send('hhh');
    // },
    // handleDisconnect(){
    //     console.log('disconnect click');
    //     ws.close();
    // }
    getTableList(){
      if(this.controlTable=="block"){
        axios.get('http://localhost:8089/block/getRecentBlocks')
        .then(function (response) {
          console.log(response);
          app.tabledata = response.data;
        })
        .catch(function (error) {
          console.log(error);
        })
      }else if(this.controlTable=="transaction"){
        axios.get('http://localhost:8089/block/getRecentBlocks')
        .then(function (response) {
          console.log(response);
          app.tabledata = response.data;
        })
        .catch(function (error) {
          console.log(error);
        })
      }
      },
     
    getTableBlocks(){
      app.controlTable = "block";
      this.getTableList();
    },
    getTableTransactions(){
      //app.controlTable = "transaction";
     // this.getTableList();
     location.href="blockChainIndex2.html";
    },

    ViewMore(){
      location.href="blockDetail.html";
    }


    }
  })