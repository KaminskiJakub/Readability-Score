# Readability-Score

Here are shown different scientific approaches to calculate a readability score.

In the bottom of this description is a text about Automated readability index. There is a table suitable for all the algorithms described in this stage. To calculate the age there is used the upper bound of the range. For example, if the range is 12-13 year olds then it's upper bound is 13 year olds.


The first algorithm is Flesch–Kincaid readability tests. First, there were created a method that calculates a number of syllables in a word. The formula is given below. Second formula was used to calculate the index; it allows to easily calculate the age of a person using the same table from the Automated Readability Index.

![FK readability](https://user-images.githubusercontent.com/33156343/96701573-0df0c280-1391-11eb-888f-ad80384585db.png)


The second one is SMOG index. It stands for Simple Measure of Gobbledygook. To calculate it, there is a need to count the number of polysyllables which is the number of words with more than 2 syllables. The formula is shown below. As in the previous example, the grade level is calculated here, so to get the age of a person you need to use the table from the first link.

![SMOG index](https://user-images.githubusercontent.com/33156343/96702145-c0288a00-1391-11eb-9f33-87e30a6fcbc5.png)


The next one is Coleman–Liau index. The formula is given below. L is the average number of characters per 100 words and S is the average number of sentences per 100 words. Like all other indices, the output is a person's grade level. Like all other indices, the result is a minimum grade level required to understand this text.

![CL index](https://user-images.githubusercontent.com/33156343/96702256-e0584900-1391-11eb-82e5-1da8e35c1f78.png)


All three approaches should be programmed and automated readability index. Also, there should be an option to choose all methods at the same time.


To count the number of syllables there are letters used : a, e, i, o, u, y as vowels. There are following 4 rules:
1. Count the number of vowels in the word.
2. Do not count double-vowels (for example, "rain" has 2 vowels but only 1 syllable).
3. If the last letter in the word is 'e' do not count it as a vowel (for example, "side" has 1 syllable).
4. If at the end it turns out that the word contains 0 vowels, then consider this word as a 1-syllable one.



## Automated readability index

The automated readability index (ARI) is a readability test for English texts, designed to gauge the understandability of a text. Like the Flesch–Kincaid grade level, Gunning fog index, SMOG index, Fry readability formula, and Coleman–Liau index, it produces an approximate representation of the US grade level needed to comprehend the text.

The formula for calculating the automated readability index is given below:

![Automated redability index score](https://user-images.githubusercontent.com/33156343/96700794-1dbbd700-1390-11eb-9026-8f3fa9f58675.png)

where characters is the number of letters and numbers, words is the number of spaces, and sentences is the number of sentences, which were counted manually by the typist when the above formula was developed. Non-integer scores are always rounded up to the nearest whole number, so a score of 10.1 or 10.6 would be converted to 11.

![Grade Level](https://user-images.githubusercontent.com/33156343/96699688-daad3400-138e-11eb-901c-6ad83531958f.png)
