/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
     const newArray = [];   // Step 1: Create an empty array to store transformed values

    for (let i = 0; i < arr.length; i++) {   // Step 2: Loop through each element
        const transformedValue = fn(arr[i],i); // Step 3: Apply the provided function
        if(transformedValue)
        newArray.push(arr[i]);        // Step 4: Push the result into newArray
    }

    return newArray;   // Step 5: Return the new transformed array
};