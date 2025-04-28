/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const newArray = [];   // Step 1: Create an empty array to store transformed values

    for (let i = 0; i < arr.length; i++) {   // Step 2: Loop through each element
        const transformedValue = fn(arr[i],i); // Step 3: Apply the provided function
        newArray.push(transformedValue);        // Step 4: Push the result into newArray
    }

    return newArray;   // Step 5: Return the new transformed array
};

