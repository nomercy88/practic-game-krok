import "regenerator-runtime";

import { TezosToolkit } from '@taquito/taquito';

const tezos = new TezosToolkit('https://api.tez.ie/rpc/edonet');

var u = ["user1", "user2", "user3", "user4", "oooik"]

const getData = async () => {
  const resultData = []
  try {
    tezos.setProvider({ rpc: `https://api.tez.ie/rpc/edonet` });
    const contract = await tezos.contract.at('KT1HQKx1mqS4Zs6zCAptTDnNNGMBNUn5P8uD');
    const storage = await contract.storage()
    u.forEach(async(el) => {
      const res = await storage.userRecords.get(el)
      resultData.push(res)
      let h1 = document.createElement('h1');
      h1.className = "data";
      h1.innerHTML = el + ' - ' + res
      document.body.append(h1);
    })
  }
  catch (err) {
    console.log(err)
  }
}
getData()
