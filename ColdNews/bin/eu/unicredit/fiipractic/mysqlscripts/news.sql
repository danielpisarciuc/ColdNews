--
-- Create table 'news' in 'fii_practic database'
--
CREATE TABLE IF NOT EXISTS `news` (
`id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `shortText` varchar(150) NOT NULL,
  `longText` varchar(300) NOT NULL,
  `date` date NOT NULL,
  `author` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Indexes for table `news`
--
ALTER TABLE `news` ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for table `news` 
--
ALTER TABLE `news` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
