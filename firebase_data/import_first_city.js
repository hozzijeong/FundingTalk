 const firestoreService = require('firestore-export-import');
 const firebaseConfig= require('./config.js');
 const serviceAccount = require('./serviceAccount.json');

 const jsonToFirestore = async() => {
   try{
     console.log('Initialzing Firebase');
     await firestoreService.initializeApp(serviceAccount, firebaseConfig.databaseURL);
     console.log('Firebase Initialized');

     await firestoreService.restore('./fourth_city_info.json');
     consloe.log('Upload Success');
   }
  catch(error){
    console.log(error);
   }
 };

 jsonToFirestore();