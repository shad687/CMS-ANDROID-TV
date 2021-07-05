exports.getTime = functions.https.onCall((data,context)=>{
return Date.now()
})